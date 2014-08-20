class Helpers {
  def pwd() {
    def pwdPath = new File('.').absolutePath
    println "PWD: $pwdPath"
    return pwdPath
  }
}
