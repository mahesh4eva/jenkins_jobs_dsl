job("ruby_test_job") {
  parameters {
    stringParam("url", "http://yourapp.com", "Provide your app")
    choiceParam("env", ["QA", "Staging", "Prod"], "Select your environment")
  }

  label("ruby1")

  scm {
    github("mahesh4eva/jenkins_jobs_dsl", "master")
  }

  steps {
    shell("echo \"AUT url is \$url\" \nruby -v")
  }
}

job("ruby_test_job2") {
  parameters {
    stringParam("url", "http://yourapp.com", "Provide your app")
    choiceParam("env", ["QA", "Staging", "Prod"], "Select your environment")
  }

  label("ruby2")

  scm {
    github("mahesh4eva/jenkins_jobs_dsl", "master")
  }

  steps {
    shell("echo \"AUT url is \$url\" \nruby -v")
  }
}

listView("Ruby Jobs") {
  jobs {
    regex("(ruby.*)")
  }
  columns {
    status()
    weather()
    name()
    lastSuccess()
    lastFailure()
    lastDuration()
    buildButton()
  }
}