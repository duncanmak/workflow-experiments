def helpersScript = new GroovyScriptEngine('.').with {
  loadScriptByName('helpers.groovy')
}
this.metaClass.mixin helpersScript

pwd()