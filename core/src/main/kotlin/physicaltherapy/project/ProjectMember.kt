package physicaltherapy.project


data class ProjectMember(
    // TODO: (추가 쿼리가 불필요한 상황인데도 불구하고) projectEntity에 대한 추가 쿼리 발생하는지?
    val projectId: Long,
    val userId: String,
)
