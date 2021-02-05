Se ha procurado respetar una arquitectura MVVM, aprovechando algunas de las novedades incluídas en Jetpack. El proyecto utiliza

- ViewModel y LiveData
- Corrutinas
- Dagger
- Retrofit
- Glide
- ViewBinding

Se ha optado por utilizar dos actividades, aunque perfectamente se podría construir mediante navegación con dos fragmentos (lo cual simplificaría la implementación en una pantalla más grande del patrón Maestro-Esclavo).

Las llamadas de red para obtener imágenes mediante Glide no estaban funcionando correctamente con el path proporcionado por la API; el protocolo HTTP causa problemas. Se ha solventado forzando HTTPS.

Se han implementado algunos test utilizando MockK, aunque no cuento con la experiencia necesaria para suplir mocks con inyección de dependencias. He dejado la implementación de MarvelDataSourceRemoteTest, aunque no he conseguido hacerla funcionar. Por contra, MarvelRepositoryTest funciona perfectamente.
