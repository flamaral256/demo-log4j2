Esse projeto usa o spring-boot-starter-parent como gerenciador de dependencias somente e não o spring framework diretamente e menos ainda o spring boot.
Somente alguns modulos de suporte do vasto ecossistema do spring framework são utilizados aqui e não o IoC container propriamente.
A ideia é que a aplicação seja o mais puro java quanto possível, mas com algumas funcionalidades core como logging e jdbc facilitadas pelo spring.
O spring-boot-maven-plugin é usado para criar um jar executável com algumas classes de suporte pra loader que no total somam apenas 219K de tamanho.
