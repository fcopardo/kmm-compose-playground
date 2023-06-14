abstract class BuilderCompanion<T> where T: composable<T> {
    private var activeBuilders = mutableMapOf<String, T>()
    fun get(id : String): T {
        if(activeBuilders.containsKey(id)) return activeBuilders[id]!!
        var builder = createBuilder(id)
        activeBuilders[id] = builder
        return builder
    }

    fun dispose(id : String){
        activeBuilders.remove(id)
    }

    fun destroy(){
        activeBuilders.clear()
    }

    protected abstract fun createBuilder(id: String) : T
}