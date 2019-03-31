# fesufrj2019.1
Project for Fundaments of Software Engineering - 2019.1


## Configurando JAVAFX no Eclipse

1. Baixe a versão mais recente do Eclipse em https://www.eclipse.org/downloads/<br><br>
2. Instale o java11 pois estamos usando o JavaFX11 <br>
  2.1 Instruçoes de instalação no ubuntu aqui https://computingforgeeks.com/how-to-install-java-11-on-ubuntu-18-04-16-04-debian-9/<br><br>
3. baixe o JavaFx11 SDK aqui : https://gluonhq.com/products/javafx/<br>
  3.1 Extraia o conteudo (voce precisará do endereço da pasta depois)<br><br>
4. Inicie o eclipse.<br><br>
5. Va no menu ```Help >> Install new software...```
  5.1 em "work with" selecione: [sua versao do eclipse] - http://download.eclipse.org/releases/[sua versao do eclipse] <br>
  5.2 filtre o texto digitando e(fx)clipse e installe o pacote de instegração "integration bundles"<br>
  5.3 vá em ```window >> preferences >> java >> buildpath >> userlibraries ```,crie uma nova biblioteca e de o nome de JavaFX11 e adicione os aquivos JAR contidos na pasta lib da pasta em que você extraiu o JavaFX SDK<br><br>
6. abra o projeto<br><br>
7. clique com o botão direito no projeto e em ```build path >> Add library``` e adicione a biblioteca javaFx11 que voce criou (estará em userlibraries)<br><br>
8. va ao menu ```Run >> run configurations``` e crie uma nova configuração com o arquivo model.main como main class e adicionando em arguments/VM arguments o seguinte argumento:<br>
  ```--module-path /path/to/javafx-sdk-11.0.2/lib --add-modules=javafx.controls,javafx.fxml```<br>
substituindo path/to pelo diretorio em que extraiu a JavaFX SDK<br><br>

**Obs: Ao abrir o projeto no eclipse selecione abrir projeto e abra a pasta "VoceAluga" e não a fesufrj2019.1.**  
