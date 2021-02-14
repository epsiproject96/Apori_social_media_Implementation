#!groovy
/**
 * JenkinsFile pour le build d'une SNAPSHOT de APORI
 *
 */
pipeline {

    environment {
        team_email= 'malembedidier24@gmail.com'
        BRANCH_MASTER= 'master'
    }
    
    /**
     * STAGES FOR DEV CONTINUOUS INTEGRATION PHASE
     */
    stages {
	
	    stage('Tools informations') {
        steps {
			  //On commence par clean le workspace 
				deleteDir()
                sh 'mvn --version'
                sh 'java -version'
                sh 'env | sort'
            }
        }

        stage('Checkout Repository') {
            steps {
                checkout scm
            }
        }


        stage('Clean') {
            steps {
                withMaven(globalMavenSettingsConfig: 'global_maven_settings') {
                    echo 'Clean with Maven'
                    sh "mvn clean"
                }
            }
        }

        stage('Unit tests') {
            steps {
                withMaven(globalMavenSettingsConfig: 'global_maven_settings') {
                    echo 'Unit testing with Maven'
                    sh "mvn test -Dmaven.test.failure.ignore=true"
                }
            }
        }
        
		
	 stage('Build and deploy artifact to Nexus') {
            steps {
                configFileProvider([configFile(fileId: 'maven_settings', variable: 'MAVEN_SETTINGS')]) {
                    echo 'Building with Maven'
                    script {
		                if (env.BRANCH_NAME == env.BRANCH_DEVELOP) {
		                    sh "mvn -s $MAVEN_SETTINGS deploy -U -DskipTests=true -Pdelivery"
		                } else {
		                    sh "mvn -s $MAVEN_SETTINGS package -U -DskipTests=true -Pdelivery"
		                }
                    }
                }
            }
        }
    }


    /**
     * POST RESULT OPERATIONS
     */
    post {
        failure {
            mail bcc: '',
                    cc: '',
                    replyTo: '',
                    mimeType: "text/html",
                    from: env.GIT_AUTHOR_EMAIL,
                    to: env.team_email,
                    subject: '[SFC] Batch OpenAM-UI Snapshot: FAIL',
                    body: "Batch OpenAM-UI  pipeline SNAPSHOT fail please see: <a href=\"${env.BUILD_URL}\">${env.BUILD_URL}</a> <br /> <br /> <img src=\"http://oi67.tinypic.com/affpg8.jpg\" />"
        }
        fixed {
            mail bcc: '',
                    cc: '',
                    replyTo: '',
                    mimeType: "text/html",
                    from: env.GIT_AUTHOR_EMAIL,
                    to: env.team_email,
                    subject: 'APORI OpenAM-UI Snapshot: Fixed',
                    body: "APORI  pipeline SNAPSHOT is back to normal! <br /> <br /> <img src=\"http://i64.tinypic.com/9archz.jpg\" />"
        }
    }
}