create table "APP".INFORMACOES
(
	COD INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	CODFUNCIONARIO INTEGER,
	NOME VARCHAR(100),
	DATA DATE,
	HORA TIME
)