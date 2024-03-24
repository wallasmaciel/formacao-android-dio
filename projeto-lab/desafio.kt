// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String = "")

data class ConteudoEducacional(val nome: String, val duracao: Int)
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val maxInscritos: Int = -1) {
    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        // Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos)
        inscritos.add(usuario)
        // -1 significa que não tem limitação de inscrição
        if (maxInscritos != -1 && maxInscritos == inscritos.size)
            throw Exception("Capacidade máxima de inscrição foi alcançada.")
    }
}

fun main() {
    // Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las
    // Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão
    val formacaoAndroid = Formacao("Formação Android", listOf(
        ConteudoEducacional("Aprendendo a linguagem Kotlin", 10),
        ConteudoEducacional("Desenvolvimento nativo", 360),
        ConteudoEducacional("Projeto de conclusão", 12),
    ), 4)

    var incluirUsuarios: Boolean
    do {
        try {
            incluirUsuarios = with<Usuario, Boolean>(Usuario()) {
                print("Digite o nome do usuário da matrícula: ")
                nome = readln()
                //
                if (nome.trim().isNotEmpty())
                    formacaoAndroid.matricular(this)
                nome.trim().isNotEmpty()
            }
        } catch (e: Exception) {
            println(e.message)
            incluirUsuarios = false
        }
    } while(incluirUsuarios)
    //
    println("----------------------------")
    println("Lista de usuários inscritos:")
    formacaoAndroid.inscritos.map { inscrito -> println(inscrito.nome) }
}