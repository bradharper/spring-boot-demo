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
                       sh "oc new-app lawwton/image-filter"
                       sh "oc new-app lawwton/image-ui -e GRAY_FILTER_SERVICE_HOST=image-filter -e GRAY_FILTER_SERVICE_PORT=8081"
                       sh "oc expose service image-ui"
                     }
                   }
                 }
              }
           }
        }
    }

