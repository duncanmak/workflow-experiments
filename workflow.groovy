// This might fail.
node('master') {
  git url: "git@github.com:duncanmak/workflow-experiments.git", branch: "trial-four"
  sh "scripts/workspace_status.sh"
  try {
    sh "scripts/script1.sh"
    // Generate a random fail (script calls 'exit $1')
    sh "scripts/script1.sh $(($RANDOM%2))"
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
