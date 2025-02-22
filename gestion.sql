PGDMP  2                    |            gestion_pedidos    16.3    16.3     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16398    gestion_pedidos    DATABASE     �   CREATE DATABASE gestion_pedidos WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Spanish_Peru.1252';
    DROP DATABASE gestion_pedidos;
                postgres    false            �            1259    16457    clientes    TABLE     �   CREATE TABLE public.clientes (
    id integer NOT NULL,
    nombres character varying(100),
    apellidos character varying(100),
    email character varying(255),
    telefono character varying(15)
);
    DROP TABLE public.clientes;
       public         heap    postgres    false            �            1259    16456    clientes_id_seq    SEQUENCE     �   CREATE SEQUENCE public.clientes_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 &   DROP SEQUENCE public.clientes_id_seq;
       public          postgres    false    218            �           0    0    clientes_id_seq    SEQUENCE OWNED BY     C   ALTER SEQUENCE public.clientes_id_seq OWNED BY public.clientes.id;
          public          postgres    false    217            �            1259    16409 	   productos    TABLE     �   CREATE TABLE public.productos (
    id integer NOT NULL,
    nombre character varying(100),
    descripcion text,
    precio numeric(10,2),
    cantidad integer
);
    DROP TABLE public.productos;
       public         heap    postgres    false            �            1259    16408    productos_id_seq    SEQUENCE     �   CREATE SEQUENCE public.productos_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.productos_id_seq;
       public          postgres    false    216            �           0    0    productos_id_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.productos_id_seq OWNED BY public.productos.id;
          public          postgres    false    215            V           2604    16460    clientes id    DEFAULT     j   ALTER TABLE ONLY public.clientes ALTER COLUMN id SET DEFAULT nextval('public.clientes_id_seq'::regclass);
 :   ALTER TABLE public.clientes ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    218    217    218            U           2604    16412    productos id    DEFAULT     l   ALTER TABLE ONLY public.productos ALTER COLUMN id SET DEFAULT nextval('public.productos_id_seq'::regclass);
 ;   ALTER TABLE public.productos ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    215    216    216            �          0    16457    clientes 
   TABLE DATA           K   COPY public.clientes (id, nombres, apellidos, email, telefono) FROM stdin;
    public          postgres    false    218   �       �          0    16409 	   productos 
   TABLE DATA           N   COPY public.productos (id, nombre, descripcion, precio, cantidad) FROM stdin;
    public          postgres    false    216   �       �           0    0    clientes_id_seq    SEQUENCE SET     >   SELECT pg_catalog.setval('public.clientes_id_seq', 39, true);
          public          postgres    false    217            �           0    0    productos_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.productos_id_seq', 14, true);
          public          postgres    false    215            Z           2606    16462    clientes clientes_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.clientes
    ADD CONSTRAINT clientes_pkey PRIMARY KEY (id);
 @   ALTER TABLE ONLY public.clientes DROP CONSTRAINT clientes_pkey;
       public            postgres    false    218            X           2606    16416    productos productos_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.productos
    ADD CONSTRAINT productos_pkey PRIMARY KEY (id);
 B   ALTER TABLE ONLY public.productos DROP CONSTRAINT productos_pkey;
       public            postgres    false    216            �   Y   x�3��*M�KT�)�,�8��(�J�'� ��3$��������iinabjfhd�el֔�Y��Y�X\��Y\�P\�Pehl����� �`�      �   t   x�3��I,KL�/JT�q���9�L�8M�L8�s�K��B�8CRsR�2��R�9�����L9}���- �\�Ɯ�y%�9�y@	$�1�.C<.1�9%F��� c1[     