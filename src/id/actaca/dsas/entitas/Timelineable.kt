package id.actaca.dsas.entitas

interface Timelineable {
    var   timeline_index:Int
    var   timeline_loop:Int
    var   timeline_position:Int
    var   timeline_running:Int
    var   timeline_speed:Int
}