CREATE DATABASE ensias_doc;
USE ensias_doc;

CREATE TABLE element(
    elm_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    elm_name VARCHAR(100) NOT NULL,
    elm_module VARCHAR(100) NOT NULL,
    elm_description VARCHAR(100) ,
    elm_annee VARCHAR(10) NOT NULL,
    elm_semester VARCHAR(10) NOT NULL,
    date_exam DATE
);

CREATE TABLE filiere(
    filiere_name VARCHAR(255) PRIMARY KEY NOT NULL,
    filiere_abs VARCHAR(100) NOT NULL
);

CREATE TABLE user(
    user_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    user_f_name VARCHAR(50) NOT NULL,
    user_l_name VARCHAR(50) NOT NULL,
    user_email VARCHAR(50) NOT NULL UNIQUE,
    user_password VARCHAR(256) NOT NULL,
    user_is_admin BOOLEAN ,
    user_num VARCHAR(50) ,
    user_nv VARCHAR(50),
    user_filiere VARCHAR(100),
    CONSTRAINT fk_user_filiere        
        FOREIGN KEY (user_filiere)            
        REFERENCES filiere(filiere_name)
);



CREATE TABLE document(
    doc_id INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
    doc_name VARCHAR(255) NOT NULL,
    doc_path VARCHAR(300) NOT NULL,
    doc_type VARCHAR(100) NOT NULL,
    doc_mime VARCHAR(50) NOT NULL,
    doc_elm int NOT NULL,
    CONSTRAINT fk_doc_elm          
        FOREIGN KEY (doc_elm)            
        REFERENCES element(elm_id)
);

create table inscrit(
    id_elm INT,
    id_user INT,
    CONSTRAINT fk_user_inscrit        
        FOREIGN KEY (id_user)            
        REFERENCES user(user_id),
    CONSTRAINT fk_elm_inscrit       
        FOREIGN KEY (id_elm)            
        REFERENCES element(elm_id),
    PRIMARY KEY (id_elm,id_user)
);
CREATE TABLE filiere_element(
    id_fil VARCHAR(50),
    id_elm INT,
    CONSTRAINT pf_filiere_element PRIMARY KEY (id_fil, id_elm),
    CONSTRAINT fk_fil_name        
        FOREIGN KEY (id_fil)            
        REFERENCES filiere(filiere_name),
    CONSTRAINT fk_element_code          
        FOREIGN KEY (id_elm)            
        REFERENCES element(elm_id)
); 
 
CREATE TABLE todos(
    todo_id INT AUTO_INCREMENT PRIMARY KEY,
    todo_title VARCHAR(255),
    todo_description VARCHAR(500),
    todo_is_done BOOLEAN,
    todo_delai DATE,
    todo_user INT NOT NULL,
    CONSTRAINT fk_todo_user          
        FOREIGN KEY (todo_user)            
        REFERENCES user(user_id)
);  

INSERT INTO filiere
VALUES ('GL','Genie logiciel'),
        ('IWIM','Ingénierie du Web et Informatique Mobile'),
        ('eMBI','e-Management et Business Intelligence'),
        ('SSI','Securite des Systemes d\'Information'),
        ('ISEM','Ingenierie des Systemes Embarques, Mobiles'),
        ('IeL','Ingenierie e-Logistique'),
        ('IDF','Ingenierie Digitale pour la Finance'),
        ('2IA','Ingenierie Intelligence Artificielle');
