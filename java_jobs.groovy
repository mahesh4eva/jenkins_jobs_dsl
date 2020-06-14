job("java_test_job") {
  parameters {
    stringParam("url", "http://yourapp.com", "Provide your app")
    choiceParam("env", ["QA", "Staging", "Prod"], "Select your environment")
  }

  label("maven1")

  scm {
    github("rajumavuri/jenkins_dsl", "master")
  }

  steps {
    shell("echo \"AUT url is \$url\" \njava -version")
  }
}