node('master') {
  git url: "git@github.com:duncanmak/workflow-experiments.git", branch: "trial-one"
  sh "scripts/workspace_status.sh"
  try {
    sh "scripts/script1.sh fail"
    echo "We shouldn't reach this step."
  } catch (Throwable t) {
    t.printStackTrace()
    echo "A step failed to execute properly"
  }
  sh "scripts/workspace_status.sh"
}
