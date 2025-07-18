package btc.renaud.dualtextdisplayextension.entries.instance

import com.typewritermc.core.books.pages.Colors
import com.typewritermc.core.entries.Ref
import com.typewritermc.core.entries.emptyRef
import com.typewritermc.core.extension.annotations.Entry
import com.typewritermc.core.extension.annotations.OnlyTags
import com.typewritermc.core.extension.annotations.Help
import com.typewritermc.core.extension.annotations.Default
import com.typewritermc.core.extension.annotations.Tags
import com.typewritermc.core.utils.point.Position
import com.typewritermc.core.utils.point.Vector
import com.typewritermc.engine.paper.entry.entity.SimpleEntityDefinition
import com.typewritermc.engine.paper.entry.entity.SimpleEntityInstance
import com.typewritermc.engine.paper.entry.entries.*
import btc.renaud.dualtextdisplayextension.entries.definition.DualTextDisplayDefinition

@Tags("dual_text_display_instance")
@Entry(
    "dual_text_display_instance",
    "A typewriter instance that creates two text display entities - one main and one secondary with configurable X, Y, Z offset",
    Colors.CYAN,
    "material-symbols:text-ad-rounded"
)
class TypewriterDualTextDisplayInstance(
    override val id: String = "",
    override val name: String = "",
    override val definition: Ref<DualTextDisplayDefinition> = emptyRef(),
    override val spawnLocation: Position = Position.ORIGIN,
    @OnlyTags("generic_entity_data", "display_data", "lines", "text_display_data")
    override val data: List<Ref<EntityData<*>>> = emptyList(),
    override val activity: Ref<out SharedEntityActivityEntry> = emptyRef(),
    @Help("Offset (X, Y, Z) for the secondary text display entity (automatically created with empty text)")
    @Default(Vector.ZERO_JSON)
    val secondaryOffset: Vector = Vector.ZERO,
) : SimpleEntityInstance {
    
    // Méthode pour obtenir la position de la seconde entité
    fun getSecondaryPosition(): Position {
        return spawnLocation.add(secondaryOffset)
    }
    
    // La seconde entité est toujours créée automatiquement
    fun hasSecondaryDefinition(): Boolean {
        return true
    }
    
    // Créer automatiquement une définition vide pour la seconde entité
    fun createSecondaryDefinition(): DualTextDisplayDefinition {
        return DualTextDisplayDefinition(
            id = "${id}_secondary",
            name = "", // Nom vide comme demandé
            displayName = ConstVar("")
        )
    }
}
