# FOLHETOS BRASIL
## PROJETO INTEGRADOR
- Curso: Análise e Desenvolvimento de Sistemas
- Grupo: 8
- Integrantes:
    - SEBASTIAO ANTONIO DE SA COSTA
    - EVERSON DANIEL DA SILVA
    - GISELA DE ARAUJO
    - RAPHAEL DE MELLO
    - TIAGO MARTINS LEAL DE LIMA
    - LARISSA OLIVEIRA HORAS

### Como executar localmente
- Instale o banco de dados Postgres:
    - banco deve ser instalado na porta padrão: `5432`
    - login deve ser: `postgres`
    - senha deve ser: `postgres`
    - criar uma database com o nome `folhetosbrasil`
- Executar o projeto localmente (pelo terminal):
    - vá para o diretório do projeto: `cd C:\{seu caminho}\folhetos-brasil`
    - execute: `mvn spring-boot:run -Dspring-boot.run.profiles=dev`
- Executar o projeto localmente (pelo método main):
    - Executar o método `main` da classe `FolhetosBrasilApplication.java`
- Acessar a URL: `http://localhost:8080/swagger-ui/index.html`
  
### HEROKU
- Este projeto está hospedado no Heroku na seguinte URL: 
```
https://folhetos-brasil-group8-senac.herokuapp.com/swagger-ui/index.html
```