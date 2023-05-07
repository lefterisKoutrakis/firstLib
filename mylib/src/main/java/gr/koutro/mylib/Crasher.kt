package gr.koutro.mylib

interface CrashListener {
    fun onUncaughtException(thread: Thread, throwable: Throwable)
}

object Woah {
    @JvmStatic
    fun init(crashListener: CrashListener) {
        Thread.setDefaultUncaughtExceptionHandler { p0, p1 ->
            crashListener.onUncaughtException(p0, p1)
        }
    }
}