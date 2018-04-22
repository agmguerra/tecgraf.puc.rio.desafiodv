# tecgraf.puc-rio desafiodv

Projeto: Desafio tecgraf.puc-rio
Este projeto foi desenvolvido na linguagem Java
versão JDK: 1.8
O projeto foi desenvolvido utilizando o maven como gerenciador de dependência e build
O projeto com maven pode ser obtido através do link: https://github.com/agmguerra/tecgraf.puc.rio.desafiodv

O que esta sendo enviado, obedecendo o requisitado, descrito no documento enunciadoDesafio_r5_geral.txt:
Um zip contendo os subdiretórios

src -> arquivos ".java" das classes do projeto e de testes (JUnit)
bin -> arquivos ".class" gerados para serem executados
arquivos -> contém os arquivos ".txt" que servem de entrada e os de saída dos processos

Para processar os arquivos execute os comandos a seguir:

1 - unzip do arquivo alexandreguerratecgrafpurio.zip em um diretório
2 - Ir para o diretório <bin> onde deverão estar os arquivos ".class"
3 - Para gerar o arquivo com DV executar:
    java br.com.tecgraf.puc.rio.desafiodv.DvHandlerMain -V <dir instalação do zip>\arquivos\matriculasSemDV.txt <dir instalação do zip>\arquivos\matriculasComDV.txt
4 - Para gerar o arquivo com DV executar:
    java br.com.tecgraf.puc.rio.desafiodv.DvHandlerMain -V <dir instalação do zip>\arquivos\matriculasParaVerificar.txt <dir instalação do zip>\arquivos\matriculasVerificadas.txt
	
*******
TESTES
*******

Foram incluídas as seguintes classes para teste unitário:

DvHandlerControlTeste.java
- testeGenerateMatriculaComDv = Testa a geração do arquivo com as matriculas com DV a partir do arquivo sem DvHandlerControlTeste
- testeValidateMatriculaComDv = Testa a validação do digitos verificadores contidos no arquivo, gerando um arquivo de resultado e compara os dois

Matricula.java
- testeCalculaDvOk = Testa o cálculo do DV para algumas matriculas
- testeCalculaDvMatriculaInvalida.java = Testa o cálculo do DV para uma matricula inválida (caracter não númerico)
  Neste caso, como não está definido um procedimento da documentação, assumimos que para estes casos o método retorna null
- testeCalculaDvHexa = Testa o cálculo do DV para o caso em que o resto da divisão por 16 é maior que 9 e o valor do DV dever ser o hexa
  equivalente

ParameterTeste.java
- testeNumeroParametrosError = Testa se o número de parâmetros informado está errado (<>3)
- testeCommandParamError = Teste se o comando informado como parâmetro é "-G" ou "-V"
- testeInputDirParamError = Testa se o path do arquivo de entrada está correto
- testeOutputDirParamError = Testa se o path do arquivo de saída está correto


