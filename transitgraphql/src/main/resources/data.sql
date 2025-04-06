-- Insertar propietarios
INSERT INTO propietario (identificacion, tipo_propietario, tipo_documento, nombre, direccion, correo)
VALUES ('123456789', 'Persona', 'CC', 'Juan Perez', 'Calle 123, Bogota', 'proyectoesp647@gmail.com');

INSERT INTO propietario (identificacion, tipo_propietario, tipo_documento, nombre, direccion, correo)
VALUES ('987654321', 'Persona', 'CC', 'Maria Gomez', 'Carrera 45, Medellin', 'proyectoesp647@gmail.com');

INSERT INTO propietario (identificacion, tipo_propietario, tipo_documento, nombre, direccion, correo)
VALUES ('900123456', 'Empresa', 'NIT', 'Transporte SA', 'Avenida 10, Cali', 'proyectoesp647@gmail.com');


-- Insertar vehículos
INSERT INTO vehiculo (tipo) VALUES ('Automovil');
INSERT INTO vehiculo (tipo) VALUES ('Moto');
INSERT INTO vehiculo (tipo) VALUES ('Carro Pesado');

-- Insertar matrículas
INSERT INTO matricula (placa, marca, fecha_matricula, propietario_id, vehiculo_id)
VALUES ('ABC123', 'Toyota', '2023-05-10', '123456789', 1);

INSERT INTO matricula (placa, marca, fecha_matricula, propietario_id, vehiculo_id)
VALUES ('XYZ789', 'Honda', '2022-08-15', '987654321', 2);

INSERT INTO matricula (placa, marca, fecha_matricula, propietario_id, vehiculo_id)
VALUES ('LMN456', 'Volvo', '2021-11-20', '900123456', 3);

-- Insertar infracciones
INSERT INTO infraccion (fecha, accionada_por, placa)
VALUES ('2024-03-10', 'Agente', 'ABC123');

INSERT INTO infraccion (fecha, accionada_por, placa)
VALUES ('2024-03-11', 'Camara', 'ABC123');

INSERT INTO infraccion (fecha, accionada_por, placa)
VALUES ('2024-02-20', 'Camara', 'XYZ789');

INSERT INTO infraccion (fecha, accionada_por, placa)
VALUES ('2024-01-05', 'Agente', 'LMN456');
