node('master') {
  git url: "git@github.com:duncanmak/workflow-experiments.git", branch: "trial-one"
  sh "scripts/workspace_status.sh"
  sh "scripts/script1.sh"
}