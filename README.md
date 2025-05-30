==============================================
Bruno Soares Vilalba - 1044917

Felipe Yuji Naraki - 10443778

Aruak Teixeira Malta - 10443742
==============================================

Para instalar o Maven, acesse o site oficial https://maven.apache.org/download.cgi e baixe a última versão estável. Depois, extraia o arquivo ZIP em uma pasta de sua escolha, por exemplo: C:\Program Files\Apache\Maven. Em seguida, configure as variáveis de ambiente: defina MAVEN_HOME apontando para a pasta onde extraiu o Maven e adicione %MAVEN_HOME%\bin ao Path do sistema. Para verificar se a instalação foi bem-sucedida, abra o terminal (Prompt de Comando ou PowerShell) e digite mvn -v. A versão instalada do Maven deve ser exibida.

No Visual Studio Code, é necessário instalar as extensões: Extension Pack for Java (by Microsoft), Maven for Java e Java Web App - Servlet Support. Depois, certifique-se de que o VSCode está apontando corretamente para o seu JDK e para o Maven. Para rodar o projeto, abra o terminal interno do VSCode (atalho Ctrl + ) e utilize os comandos Maven diretamente. 
O comando mvn clean install irá limpar, compilar, testar, empacotar e instalar tudo de novo, do zero. 
Já o comandomvn jetty:run irá iniciar o servidor Jetty embutido, disponibilizando o site emhttp://localhost:8080/%60.

É importante garantir que o terminal esteja aberto na raiz do projeto, onde está localizado o arquivo pom.xml. Se ocorrer um erro informando que o plugin Jetty não foi encontrado, normalmente isso se resolve com a execução de mvn clean install. A primeira vez que rodar o projeto pode demorar um pouco, pois o Maven precisa baixar todas as dependências. Sempre que alterar algum arquivo .java, é necessário parar a execução e rodar novamente mvn clean install seguido de mvn jetty:run.

Como alternativa ao VSCode, é possível utilizar o Eclipse IDE com suporte a projetos dinâmicos com Maven, além de instalar o Apache Tomcat 9 como servidor de aplicações.

Os usuários de teste são: admin@mackenzie.br com a senha admin123, e james.brown@soul.com com a senha 123.Para instalar o Maven, acesse o site oficial https://maven.apache.org/download.cgi e baixe a última versão estável. Depois, extraia o arquivo ZIP em uma pasta de sua escolha, por exemplo: C:\Program Files\Apache\Maven. Em seguida, configure as variáveis de ambiente: defina MAVEN_HOME apontando para a pasta onde extraiu o Maven e adicione %MAVEN_HOME%\bin ao Path do sistema. Para verificar se a instalação foi bem-sucedida, abra o terminal (Prompt de Comando ou PowerShell) e digite mvn -v. A versão instalada do Maven deve ser exibida.

No Visual Studio Code, é necessário instalar as extensões: Extension Pack for Java (by Microsoft), Maven for Java e Java Web App - Servlet Support. Depois, certifique-se de que o VSCode está apontando corretamente para o seu JDK e para o Maven. Para rodar o projeto, abra o terminal interno do VSCode (atalho Ctrl + ) e utilize os comandos Maven diretamente. 
O comando mvn clean install irá limpar, compilar, testar, empacotar e instalar tudo de novo, do zero. 
Já o comandomvn jetty:run irá iniciar o servidor Jetty embutido, disponibilizando o site em http://localhost:8080/.

É importante garantir que o terminal esteja aberto na raiz do projeto, onde está localizado o arquivo pom.xml. Se ocorrer um erro informando que o plugin Jetty não foi encontrado, normalmente isso se resolve com a execução de mvn clean install. A primeira vez que rodar o projeto pode demorar um pouco, pois o Maven precisa baixar todas as dependências. Sempre que alterar algum arquivo .java, é necessário parar a execução e rodar novamente mvn clean install seguido de mvn jetty:run.

Como alternativa ao VSCode, é possível utilizar o Eclipse IDE com suporte a projetos dinâmicos com Maven, além de instalar o Apache Tomcat 9 como servidor de aplicações.

Os usuários de teste são: admin@mackenzie.br com a senha admin123, e james.brown@soul.com com a senha 123.
