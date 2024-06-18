package com.toniazzo.acolhebrasil.models.enums;

public enum State {

    AMAZONAS("Amazonas", "AM", "Manaus"),
    ALAGOAS("Alagoas", "AL", "Maceió"),
    ACRE("Acre", "AC", "Rio Branco"),
    AMAPA("Amapá", "AP", "Macapá"),
    BAHIA("Bahia", "BA", "Salvador"),
    PARA("Pará", "PA", "Belém"),
    MATO_GROSSO("Mato Grosso", "MT", "Cuiabá"),
    MINAS_GERAIS("Minas Gerais", "MG", "Belo Horizonte"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS", "Campo Grande"),
    GOIAS("Goiás", "GO", "Goiânia"),
    MARANHAO("Maranhão", "MA", "São Luís"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS", "Porto Alegre"),
    TOCANTINS("Tocantins", "TO", "Palmas"),
    PIAUI("Piauí", "PI", "Teresina"),
    SAO_PAULO("São Paulo", "SP", "São Paulo"),
    RONDONIA("Rondônia", "RO", "Porto Velho"),
    RORAIMA("Roraima", "RR", "Boa Vista"),
    PARANA("Paraná", "PR", "Curitiba"),
    CEARA("Ceará", "CE", "Fortaleza"),
    PERNAMBUCO("Pernambuco", "PE", "Recife"),
    SANTA_CATARINA("Santa Catarina", "SC", "Florianópolis"),
    PARAIBA("Paraíba", "PB", "João Pessoa"),
    RIO_GRANDE_DO_NORTE("Rio Grande do Norte", "RN", "Natal"),
    ESPIRITO_SANTO("Espírito Santo", "ES", "Vitória"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ", "Rio de Janeiro"),
    SERGIPE("Sergipe", "SE", "Aracaju"),
    DISTRITO_FEDERAL("Distrito Federal", "DF", "Brasília");

    private final String stateName;
    private final String acronym;
    private final String capital;

    State(final String stateName, final String acronym, final String capital) {
        this.stateName = stateName;
        this.acronym = acronym;
        this.capital = capital;
    }
    
    public static State fromUF(final String stateNameUf) {
        for (final State state : State.values()) {
            if (state.stateName.equalsIgnoreCase(stateNameUf)) {
                return state;
            }
        }

        throw new IllegalArgumentException(stateNameUf);
    }
    
    public static State fromSigla(final String acronym) {
        for (final State state : State.values()) {
            if (state.acronym.equalsIgnoreCase(acronym)) {
                return state;
            }
        }

        throw new IllegalArgumentException(acronym);
    }
    
    public static State fromCapital(final String capital) {
        for (final State state : State.values()) {
            if (state.capital.equalsIgnoreCase(capital)) {
                return state;
            }
        }

        throw new IllegalArgumentException(capital);
    }
    
    public String acronym() {
        return this.acronym;
    }
    
    public String stateName() {
        return this.stateName;
    }
    
    public String capital() {
        return this.capital;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("State{");
        sb.append("stateName='").append(stateName).append('\'');
        sb.append(", acronym='").append(acronym).append('\'');
        sb.append(", capital='").append(capital).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
