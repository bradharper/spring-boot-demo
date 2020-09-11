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
                           sh 'oc delete bc/spring-boot-app-jenkinsfile'
                           sh 'oc delete svc/spring-boot-app-jenkinsfile'
                           sh 'oc new-app registry.access.redhat.com/redhat-openjdk-18/openjdk18-openshift~http://github.com/bradharper/spring-boot-demo.git  --name=spring-boot-app-jenkinsfile -e TEST.ENVIRONMENT.MESSAGE=test -e test.property.message=Different -e TEST.ENVIRONMENT.MESSAGE=DIFFERENT'
                           sh 'oc expose svc/spring-boot-app-jenkinsfile'
                       }
                   }
               }
           }
       }
   }
}

