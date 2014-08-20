// This shouldn't fail.
node('master') {
  git url: "git@github.com:duncanmak/workflow-experiments.git", branch: "trial-one"
  sh "scripts/workspace_status.sh"
  try {
    sh "scripts/script1.sh"
    sh "scripts/script1.sh 0"
    echo "Build completed!"
  } catch (Throwable t) {
    t.printStackTrace()
    echo "A step failed to execute properly"
    throw new Exception("Fatal error during execution, flow cannot continue.")
  } finally {
    echo "Cleaning up build..."
    sh "scripts/workspace_status.sh"
  }
}
