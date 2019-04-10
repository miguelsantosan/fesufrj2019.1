# fesufrj2019.1
Project for Fundaments of Software Engineering - 2019.1


## Configurando JAVAFX no Eclipse

1. Baixe a versão uma versão do eclipse (com exceção da 2019)<br>
  1.1 Para instalar uma versão antiga basta clicar em advanced mode no instalador<br>
  1.2 Selecione o Java 8 e versão mais antiga do eclipse (neon por exemplo)<br><br>
2. Inicie o eclipse.<br><br>
3. Va no menu ```Help >> Install new software...```<br>
  3.1 em "work with" selecione: "[sua versao do eclipse] - http://download.eclipse.org/releases/ [sua versao do eclipse]"<br>
  3.2 filtre o texto digitando e(fx)clipse e instale o e(fx)clipse IDE<br><br>
4. Se o projeto ainda não estiver identificando o javaFX, baixe a javaFX_SDK, extraia o conteudo e link no projeto do seguinte modo:<br>
  4.1 vá em ```window >> preferences >> java >> buildpath >> userlibraries ```,crie uma nova biblioteca e de o nome de JavaFX e      adicione os aquivos JAR contidos na pasta lib da pasta em que você extraiu o JavaFX SDK<br>
  4.2 lique com o botão direito no projeto e em ```build path >> Add library``` e adicione a biblioteca javaFx que voce criou (estará em userlibraries)<br><br>


**Obs: Ao abrir o projeto no eclipse selecione abrir projeto e abra a pasta "VoceAluga" e não a fesufrj2019.1.**  
