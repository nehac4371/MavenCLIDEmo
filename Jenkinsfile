pipeline {
  agent any
  stages {	
	stage('Maven Compile'){
		steps{
			echo 'Project compile stage'
			bat label: 'Compilation running', script: '''mvn compile'''
	       	}
	}
	
	stage('Unit Test') {
	   steps {
			echo 'Project Testing stage'
			bat label: 'Test running', script: '''mvn test'''
	       
       }
   	}
	  
	stage('Jacoco Coverage Report') {
        steps{
            jacoco()
		}
	}
	  
	 stage('SonarQube'){
         steps{
            bat label: '', script: '''mvn sonar:sonar \
		 -Dsonar.host.url=http://localhost:9000 \
 		-Dsonar.login=8f0c6adb70b43372c63524783d8949f474f8acca'''
          }
      }
	  
stage('Jmeter'){
         steps{
            bat label: 'jmeter',script:'jmeter -n -Jjmeter.save.saveservice.output_format=xml -t C:\\jmetertestplans\\jmeter-demo.jmx -l C:\\jmeter-test-results\\test-demo.jtl'
          }
	}


	
	stage('Maven Package'){
		steps{
			echo 'Project packaging stage'
			bat label: 'Project packaging', script: '''mvn package'''
		}
	} 
	  
	stage('Execute .jar file'){
		steps{
			echo 'execution'
			bat label: 'project execution', script: '''java -jar target/maven-CLI-demo.jar com.example.user.App'''
		}
	}
    
  }
}
