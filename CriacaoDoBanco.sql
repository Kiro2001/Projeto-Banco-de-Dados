create database avaliacao_turma
default character set utf8mb4
default collate utf8mb4_general_ci;
use avaliacao_turma;

create table Departamento(
cod smallint NOT NULL,
nome varchar(1000),
primary key(cod)
)default charset = utf8mb4;



create table Aluno(
matricula varchar(9) NOT NULL,
email varchar(200) ,
nome varchar(100),
senha varchar(50),
curso varchar(200),
adminT boolean,
foto_perfil mediumblob,
primary key(matricula)
);


create table Professor(
nome varchar(100),
FKDepartamento_cod int,
foreign key(FKDepartamento_cod) references Departamento(cod)
);


create table Disciplina(
cod varchar(7),
nome varchar(200),
FKDepartamento_cod int,
primary key(cod),
foreign key(FKDepartamento_cod) references Departamento(cod)
);



create table Turma(
idTurma int not null auto_increment,
numTurma int,
periodo varchar(6),
horario varchar(20),
vagas_ocupadas int,
total_vagas int ,
local_aula varchar(250),
FKnome_professor varchar(100),
FKcod_disciplina varchar(7),
primary key(idTurma),
foreign key(FKnome_professor) references Professor(nome),
foreign key(FKcod_disciplina) references Disciplina(cod)
);



create table Avaliacao(
idAval int not null auto_increment,
comentario varchar(5000),
nota int,
FKmatricula varchar(9),
FKidturma int,
primary key(idAval),
foreign key(FKmatricula) references Aluno(matricula),
foreign key(FKidturma) references Turma(idTurma)
);


create table Denuncia(
idDen int not null auto_increment,
motivo_den enum('Palavras de baixo calão','Falou alguma mentira','Outro'),
outro_motivo varchar(500),
FKidAval int,
FKmatriculaDelator varchar(9),
primary key(idDen),
foreign key(FKidAval) references Avaliacao(idAval),
foreign key(FKmatriculaDelator) references Aluno(matricula)
);

DELIMITER $
create procedure  Apaga_avalia(IN matriculaAluno varchar(9))
Begin
delete from Avaliacao where FKmatricula=matriculaAluno;
End $
DELIMITER ;

DELIMITER $
create procedure  Apaga_denun(IN idComen int)
Begin
delete from Denuncia where FKidAval=idComen;
End $
DELIMITER ;

DELIMITER $
CREATE TRIGGER Apaga_Aluno before delete
ON Aluno
FOR EACH ROW
BEGIN
call Apaga_avalia(old.matricula);
END$
DELIMITER ;

DELIMITER $
CREATE TRIGGER Apaga_Avaliacao before delete
ON Avaliacao
FOR EACH ROW
BEGIN
call Apaga_denun(old.idAval);
END$
DELIMITER ;

CREATE VIEW Alunos_Comuns AS
SELECT matricula, nome
FROM Aluno
WHERE adminT = '0';



