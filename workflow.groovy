node('master') {
  git url: "git@github.com:duncanmak/workflow-experiments.git", branch: "trial-eval"
  def helpersScript = new GroovyScriptEngine('.').with {
    loadScriptByName('helpers.groovy')
  }
  this.metaClass.mixin helpersScript

  pwd()

  sh "scripts/workspace_status.sh"
  sh "scripts/script1.sh"
  sh "scripts/workspace_status.sh"
}