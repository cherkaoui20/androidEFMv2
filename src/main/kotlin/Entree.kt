class Entree(val motFrancais: String, val motAnglais: String) {
    init {
        require(!motFrancais.isEmpty() && !motAnglais.isEmpty()) { "no vide" }
    }

    override fun toString(): String {
        return "$motFrancais:$motAnglais"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || other !is Entree) return false
        return motFrancais == other.motFrancais
    }

    override fun hashCode(): Int {
        return motFrancais.hashCode()
    }
}

class Dictionnaire {
    private val entrees = ArrayList<Entree>()

    fun nombreEntrees(): Int {
        return entrees.size
    }

    fun ajouter(e: Entree) {
        if (entrees.contains(e)) {
            throw IllegalArgumentException(" oui")
        }
        entrees.add(e)
    }

    fun supprimer(e: Entree): Boolean {
        return entrees.remove(e)
    }

    fun supprimer(motFrancais: String): Boolean {
        val it = entrees.iterator()
        while (it.hasNext()) {
            val e = it.next()
            if (e.motFrancais == motFrancais) {
                it.remove()
                return true
            }
        }
        return false
    }

    fun anFr(motAnglais: String): ArrayList<String> {
        val motsFrancais = ArrayList<String>()
        for (e in entrees) {
            if (e.motAnglais == motAnglais) {
                motsFrancais.add(e.motFrancais)
            }
        }
        return motsFrancais
    }

    fun motsAnglais(): ArrayList<String> {
        val motsAnglais = HashSet<String>()
        for (e in entrees) {
            motsAnglais.add(e.motAnglais)
        }
        return ArrayList(motsAnglais)
    }



    override fun toString(): String {
        return entrees.joinToString("\n")
    }
}
