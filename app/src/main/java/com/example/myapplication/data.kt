import java.io.Serializable
import android.annotation.SuppressLint
import androidx.annotation.NonNull


abstract class Human(
    var firstName: String? = null,
    var lastName: String? = null,
    var age: String? = null
) : Serializable {

    constructor(name: String) : this(name, null, null)

    constructor(name: String, lastName: String) : this(name, lastName, null)

    override fun toString(): String {
        return "Human = {firstName: $firstName, lastName: $lastName, age: $age}"
    }
}


class Student(
    firstName: String? = null,
    lastName: String? = null,
    age: String? = null,
    var group: String? = null
) : Human(firstName, lastName, age), Serializable {

    constructor(name: String, group: String) : this(name, null, null, group)

    constructor(name: String, lastName: String, group: String) : this(name, lastName, null, group)

    @SuppressLint("NewApi")
    @NonNull
    override fun toString(): String {
        return "Human = {firstName: $firstName, lastName: $lastName, age: $age, group: $group}"
    }
}