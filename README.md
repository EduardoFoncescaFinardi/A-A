# A & A, Agende ou Atenda.
  O projeto que desejamos realizar é um projeto de agendamento de consultas médicas, podendo ser consultas psiquiátricas, fisioterapeuticas, dermatológicas entre outros serviços no médicos. O sistema terá muitas funcionalidades, permitirá tanto quem atende (clínicas e profissionais), quanto quem quer ser atendido se registre no sistema, assim o sistema seria um portal de conexão direta entre ambos, permitindo quem atende consiga com facilidade se comunicar com quem precisa ser atendido. O sistema permitirá você filtrar por regiões (Sendo elas Cambuci, Vila Mariana e Paraíso) e serviços. O aplicativo será completo nesse quesito, permitindo diversas interações, tipos de filtros, disponibilidade de atendimentos, Telemedicina, entre muitos outros!

## Escopo
### Área de login do paceinte: (rascunho) = {id_funcionalidades_area_paciente}
- Mostrar área de pesquisa/filtro (rascunho) = (id = 1)
- Mostrar área de agendamentos (rascunho) = (id = 2)
- Informações pessoais (rascunho) = (id = 3)
- Feedback de consultas (rascunho) = (id = 4)

### Área de login do profissional
- Mostrar consultas realizadas
- Registro de serviços
- Informações do profissional
- Datas disponíveis
E segue o fio, pois ainda falta definirmos com clareza...Falta informações!

### Requesitos
- [ ] CRUD de agendamentos
- [ ] CRUD de serviços
- [ ] CRUD de locais de atendimento
- [ ] CRUD de planos de saúde
- [ ] CRUD de pacientes
- [ ] CRUD de profissionais
- [ ] Autenticação

## Endpoints
# IMPORTANTE!: DÚVIDAS
  Professor, estamos com muitas dúvidas, por isso fizemos apenas o do paciente, mas a questão é: Primeiro, quando você fez o de categorias, elas eram alteráveis pelo próprio usuário, porém as funcionalidades do perfil do paciente serão fixas, então não colcariamos em teoria nem POST e nem DELETE, correto? Segundo, Teriamos as possibilidades de alterações só em endpoints mais internos como seria no caso de /login/paciente/área_agendamentos, que ai o usuário conseguiria adicionar um novo agendamento, deletá-lo ou alterá-lo, então quando formos fazer com calma corretamente, devemos fazer o POST e o DELETE nesse caso? Terceiro, fizemos o JS porém ficamos em dúvida se ele está correto, pois no caso das categorias que o senhor mostrou, o usuário conseguiria alterar, no nosso caso o JS é fixo do sistema, não do paciente, então em teoria ele é inútil? Obrigado pela atenção, tenha um bom dia!!!! 


###Serviços  
GET /serviço

Lista todos os serviços cadastrados no sistema.

200 sucesso

GET /serviço/{id}

Retorna os detalhes de uma serviço com o id informado.

códigos de status

200 sucesso 404 id não encontrado

POST /serviço

Cadastrar uma nova serviço.

campo |tipo obrigatório descrição
nome |string ✅ Um nome curto para identificar a serviço
icone |string ❌ O nome do ícone conforme biblioteca material design
códigos de status

201 criado com sucesso 400 validação falhou

DELETE /serviço/{id}

Apaga o serviço com o id informado.

códigos de status

204 apagado com sucesso 404 id não encontrado

PUT /serviço/{id}

Altera a catagoria com o id informado.

campo tipo obrigatório descrição
nome string ✅ Novo nome curto para identificar a serviço
icone string ✅ Novo nome do ícone conforme biblioteca material design
códigos de status

200 sucesso 404 id não encontrado 400 validação falhou

Schema

{
"id": 1,
"nome": "odontologia",
"icone": "tooth-outline"
}

{
"id": 2,
"nome": "dermatologia",
"icone": "face-man"
}

{
"id": 3,
"nome": "psicologia",
"icone": "head-snowflake"
}