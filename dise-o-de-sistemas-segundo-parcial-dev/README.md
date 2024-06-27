Se desea modelar dos clases Entrenador y Pokemon.

De un Entrenador sabemos su nombre, fecha de nacimiento, nacionalidad, genero, edad y que Pokemons tiene, máximo 5.

Un Entrenador entiende:
- Entrenador enfrentarseA(Entrenador otro entrenador);
- void capturarPokemon(Pokemon pokemon) (No puede tener más de 5 pokemons)
-  Getters y setters

De un Pokemon sabemos su tipo (Eléctrico, Agua, Fuego, Vegetal, Piedra), su especie y su vída y su poder (números que van entre 0 y 100 siempre)

Un Pokemon entiende:
- void atacar(Pokemon otroPokemon);
- void restarVida(Float cant);
- void aumentarVida(Float vida);

Se desea además que la aplicacion sea capaz de:

Crear un Entrenador
Crear un Pokemon
Recuperar un Entrenador por ID
Recuperar un Pokemon por ID
Hacer que un Entrenador pueda capturar un Pokemon
Hacer que un Entrenador pueda luchar contra otro Entrenador
Buscar todos los Pokemons entre un rango de poder
Buscar todos los Entrenadores por coincidencia con el nombre, siendo esta busqueda caps insensitive
