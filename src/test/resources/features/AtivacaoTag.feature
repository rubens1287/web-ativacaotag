# language: pt
# charset: UTF-8

@PlanId=5
@SuiteId=18
Funcionalidade: Ativação Tag
   Eu como cliente gostaria de acessar o sistema e ativar minha Tag da ConectCar

   @TestId=19
   Cenario: CT001 - Ativacao Tag - Realizar ativação plano Completo (Tag vendida pela Epay)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "completo"
    Entao sera apresentado a ativacao efetuada com sucesso

  @TestId=20
  Cenario: CT002 - Ativacao Tag - Realizar ativação plano Urbano (Tag vendida pela Epay)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "urbano"
    Entao sera apresentado a ativacao efetuada com sucesso

  @TestId=21
  Cenario: CT003 - Ativacao Tag - Realizar ativação plano Rodovias (Tag vendida pela Epay)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "rodovias"
    Entao sera apresentado a ativacao efetuada com sucesso

  @TestId=22
  Cenario: CT004 - Ativacao Tag - Realizar ativação plano Basico (Tag vendida pela Epay)
    Dado eu tenha uma tag da conectcar pronta para ativar
    Quando eu efetuar ativacao de tag com plano "basico"
    Entao sera apresentado a ativacao efetuada com sucesso
