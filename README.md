# configuracoes-testes

## Como rodar

1. Tenha o docker instalado
2. Tenha o make instalado (preferência uso em linux)
3. Rode make docker-up
   `` make docker-up ``
   1. Esse comando irá gerar o a imagem docker do projeto e subir o docker compose que contém as outras depêndencias necessarias
4. Para testar acesse em seu navegador `http://localhost:8080/swagger-ui/index.html`