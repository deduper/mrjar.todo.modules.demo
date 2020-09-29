package works.hop.todo.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    T data;
    String error;

    public static <V> Result<V> of(V task) {
        return new Result<>(task, null);
    }

    public static <V> Result<V> error(String error) {
        return new Result<>(null, error);
    }
}
