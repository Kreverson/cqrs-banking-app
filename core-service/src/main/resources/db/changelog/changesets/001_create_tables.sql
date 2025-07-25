create table accounts
(
    id      varchar(36) primary key,
    number  varchar not null unique,
    balance numeric not null default 0
);

create table customers
(
    id         varchar(36) primary key,
    name       varchar     not null,
    username   varchar     not null unique,
    password   varchar     not null,
    account_id varchar(36) not null,
    constraint customers_accounts foreign key (account_id) references accounts (id)
);

create table cards
(
    id         varchar(36) primary key,
    number     varchar(16) not null,
    date       varchar(5)  not null,
    cvv        varchar(3)  not null,
    account_id varchar(36) not null,
    constraint cards_unique unique (number, date),
    constraint cards_accounts foreign key (account_id) references accounts (id)
);

create table customers_cards
(
    customer_id varchar(36) not null,
    card_id   varchar(36) not null,
    constraint customers_cards_unique unique (customer_id, card_id),
    constraint customers_cards_customers foreign key (customer_id) references customers (id),
    constraint customers_cards_cards foreign key (card_id) references cards (id)
);

create table transactions
(
    id      varchar(36) primary key,
    from_id varchar(36) not null,
    to_id   varchar(36) not null,
    amount  numeric     not null,
    constraint transactions_cards_from foreign key (from_id) references cards (id),
    constraint transactions_cards_to foreign key (to_id) references cards (id)
);

create table cards_transactions
(
    card_id        varchar(36) not null,
    transaction_id varchar(36) not null,
    constraint cards_transactions_unique unique (card_id, transaction_id),
    constraint cards_transactions_cards foreign key (card_id) references cards (id),
    constraint cards_transactions_transactions foreign key (transaction_id) references transactions (id)
);