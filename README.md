# Serviço de Envio de E-mail

Este serviço é responsável por ouvir um tópico do Kafka e executar a ação de envio de e-mail com base nas mensagens recebidas.

## Funcionalidade

O serviço se conecta a um cluster do Kafka e consome as mensagens de um tópico específico. Cada mensagem recebida representa um e-mail a ser enviado. O serviço processa as mensagens e realiza o envio de e-mail para os destinatários especificados.

## Configuração

Antes de executar o serviço, certifique-se de configurar corretamente o Kafka e fornecer as configurações necessárias. Verifique o arquivo de configuração `application.properties` para ajustar as propriedades do Kafka e servidor de email, como endereço do servidor(SMTP), como também uma conta de email ativa para configuração e o nome do tópico a ser ouvido.

## Uso

1. Certifique-se de ter o Kafka em execução e o tópico configurado corretamente.
2. Envie mensagens para o tópico do Kafka contendo as informações necessárias para o envio de e-mail, como remetente, destinatário, assunto e corpo do e-mail.
3. O serviço irá consumir as mensagens do tópico, processá-las e enviar os e-mails correspondentes.


