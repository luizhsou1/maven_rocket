CREATE TABLE public.tab_cadastro (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(50) NOT NULL,
    idade INT4 NOT NULL
);

INSERT INTO public.tab_cadastro (nome, idade) VALUES
    ('João', 23),
    ('Maria', 21)
;