import java.util.*

class SomeAPICont{
    val `1`: SomeNestedObjects = SomeNestedObjects()
    val `2`: SomeNestedObjects = SomeNestedObjects()
    val `3`: SomeNestedObjects = SomeNestedObjects()
    val `4`: SomeNestedObjects = SomeNestedObjects()
    val `5`: SomeNestedObjects = SomeNestedObjects()
    val `6`: SomeNestedObjects = SomeNestedObjects()
    val `7`: SomeNestedObjects = SomeNestedObjects()
    val `8`: SomeNestedObjects = SomeNestedObjects()
    val `9`: SomeNestedObjects = SomeNestedObjects()
    val `10`: SomeNestedObjects = SomeNestedObjects()
    val `11`: SomeNestedObjects = SomeNestedObjects()
    val `12`: SomeNestedObjects = SomeNestedObjects()
    val `13`: SomeNestedObjects = SomeNestedObjects()
    val `14`: SomeNestedObjects = SomeNestedObjects()
    val `15`: SomeNestedObjects = SomeNestedObjects()
    val `16`: SomeNestedObjects = SomeNestedObjects()
    val `17`: SomeNestedObjects = SomeNestedObjects()
    val `18`: SomeNestedObjects = SomeNestedObjects()
    val `19`: SomeNestedObjects = SomeNestedObjects()
    val `20`: SomeNestedObjects = SomeNestedObjects()
    val `21`: SomeNestedObjects = SomeNestedObjects()
    val `22`: SomeNestedObjects = SomeNestedObjects()
    val `23`: SomeNestedObjects = SomeNestedObjects()
    val `24`: SomeNestedObjects = SomeNestedObjects()
    val `25`: SomeNestedObjects = SomeNestedObjects()
    val `26`: SomeNestedObjects = SomeNestedObjects()
    val `27`: SomeNestedObjects = SomeNestedObjects()
    val `28`: SomeNestedObjects = SomeNestedObjects()
    val `29`: SomeNestedObjects = SomeNestedObjects()
    val `30`: SomeNestedObjects = SomeNestedObjects()
    val `31`: SomeNestedObjects = SomeNestedObjects()
    val `32`: SomeNestedObjects = SomeNestedObjects()
    val `33`: SomeNestedObjects = SomeNestedObjects()
    val `34`: SomeNestedObjects = SomeNestedObjects()
    val `35`: SomeNestedObjects = SomeNestedObjects()
    val `36`: SomeNestedObjects = SomeNestedObjects()
}

class SomeNestedObjects {
    val info: Long = 4L
}

fun main(){
    val someResponse = SomeAPICont()
    var critArray = Array<Long>(someResponse.javaClass.declaredFields.size){0}
    someResponse.javaClass.declaredFields.forEachIndexed{i, field ->
        println(field.name)
        critArray[i] = field.name.toLong()
    }

    println(Arrays.toString(critArray))


}