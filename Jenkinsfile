pipeline {
   agent { label "maven" }
   stages {
       stage('preamble') {
           steps {
               script {
                   openshift.withCluster() {
                   openshift.withProject() {
                       echo "Using project: ${openshift.project()}"
                     }
                   }
                 }
               }
           }
       stage('build and deploy') {
           steps {
               script {
                   openshift.withCluster() {
                       openshift.withProject() {
                           sh 'oc new-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~http://github.com/bradharper/spring-boot-demo.git  --name=spring-boot-app-jenkinsfile -e TEST.ENVIRONMENT.MESSAGE=test'
                           sh 'oc set env dc/spring-boot-app-jenkinsfile test.property.message=Different'
                           sh 'oc set env dc/spring-boot-app-jenkinsfile TEST.ENVIRONMENT.MESSAGE=DIFFERENT'
                           sh 'oc expose svc/spring-boot-app-jenkinsfile'
                       }
                   }
               }
           }
       }
   }
}

