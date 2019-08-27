class Card(name: String, suit: String) {
    //getters e setters são opcionais
    var name = name
    var suit = suit

    override fun toString(): String {
        return "[$suit $name]"
    }
}