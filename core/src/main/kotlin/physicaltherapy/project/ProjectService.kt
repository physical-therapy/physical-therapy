package physicaltherapy.project

import org.springframework.stereotype.Service

@Service
class ProjectService(
    private val projectReader: ProjectReader,
    private val projectWriter: ProjectWriter
) {
}