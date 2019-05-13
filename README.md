# cadastro_cliente_api

## Objetivo
  Criação de um projeto de WebService RestFull desenvolvido na linguagem de programação Java com a ajuda do Framework Spring Boot.
  Nesse projeto é disponibilizado varios serviços onde quem consumir poderá Cadastrar Cliente, Alterar Cliente, Pesquisar todos os Clientes cadastrados na base de dados, Pesquisar somente um Cliente pelo seu ID e Excluir um Cliente cadastrado pelo seu ID.
  
## Usando os Serviços Rest
  Quem for utilizar a api poderá chamar os serviços da seguinte forma:
  
  - Cadastrar Cliente
  
    @PostMapping("/cadCliente")
    
    public boolean cadastrarCliente(@RequestBody Cliente cli, HttpServletRequest request)
    
    Este metodo retorna um boolean (True - Caso ocorra tudo certo no cadastro; False - Ocorreu algum erro)
    Recebe como parametros um Objeto Cliente preenchido (Nome e Idade)
    
    
    -Alterar Cliente
    
     @PutMapping("/alterarCliente")
     
    public boolean alterarCliente(@RequestBody Cliente cli)
    
    Este metodo retorna um boolean (True - Caso ocorra tudo certo na alteração; False - Ocorreu algum erro)
    Recebe como parametros um Objeto Cliente preenchido (codigo cliente, Nome e Idade) 
    
    - Pesquisar Cliente por ID
   
    @GetMapping("/pesqCliente/{idCliente}")
    
    public Cliente pesqClienteID(@PathVariable long idCliente)
    
    Este metodo retorna o Objeto Cliente com todos os seus dados preenchidos
    Recebe como parametro o id do cliente
    
    - Pesquisar Todos os Clientes
    
    @GetMapping("/pesqTodosCliente")
    
    public List<Cliente> getClientes()
    
    Este metodo retorna uma lista contendo todos os clientes cadastrados na base de dados
    
    - Excluir um Cliente pelo seu ID
    
    @DeleteMapping("/deleteCli/{idCliente}")
    
    public boolean excluirClienteID(@PathVariable long idCliente)
    
    Este metodo exclui um cliente cadastrado na base de dados pelo seu ID
    Recebe como parametro o ID do cliente a ser excluido
    
    ## Ferramentas Usadas
    
    Para o desenvolvimento do projeto foi usada a linguagem de programação JAVA na sua versão 8
    
    Utilizado o Framework Spring Boot, para dar mais rapidez no desenvolvimento do Web Service, pois ja tem alguns metodos ja criados, principalmente na parte de conversao de arquivos JSON em objetos
    
    Utilizado Maven para fazer o download dos projetos de spring necessarios para o funcionamento do projeto
    
    Utilizado para salvar os dados o banco de dados PostGreSQL, aqui no github deixei o backup e o arquivo de database, caso queira criar o banco de dados
    
    Utilizado o software Postman para criar massas de testes
    
    
    ## Adicionais
    
    Para executar o projeto será necessário instalar o PostgreSQL para criar o banco de dados onde sera salvo as informações
    
    Poderá usar o arquivo database.txt para gerar o banco de dados
    
    Poderá usar o arquivo backup_cadclientes.backup para restaurar o banco de dados zerado
    
    Deixar o usuario = postgres e a senha  = postgres
    
    ## Executar e testar
    
    Para executar o projeto poderá criar uma pasta chamada app na raiz do seu sistema operacional, criar uma pasta log na pasta app e copiar a pasta target daqui do github. Dentro da pasta target poderá execuat o arquivo WSCadCliente-1.0-SNAPSHOT.jar, que o mesmo ira subir em um servidor TomCat local na maquina.
    Para Testar poderá usar o browser ou o aplicativo PostMan para chamar os serviços disponibilizados
    
    diretório ficará :
    
    /app/log
    
    /app/target
    
   
    
    
    
