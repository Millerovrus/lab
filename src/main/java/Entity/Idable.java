package Entity;

/**
 * Для имплемента к сущностям. Говорим о том, что они содержат ID
 * Для того, чтобы реализовать checkById в абстрактном классе
 * @param <ID> - ID параметром, а не int, потому что ID не всегда int, он может быть и условным String
 */
public interface Idable<ID> {
    ID getId();
}
