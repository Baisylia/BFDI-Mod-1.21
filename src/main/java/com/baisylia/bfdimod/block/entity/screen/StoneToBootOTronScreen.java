package com.baisylia.bfdimod.block.entity.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class StoneToBootOTronScreen extends AbstractContainerScreen<StoneToBootOTronMenu> {
    private static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath("bfdimod", "textures/gui/stone_to_boot_o_tron_gui.png");

    public StoneToBootOTronScreen(StoneToBootOTronMenu pMenu, Inventory pPlayerInventory, Component pTitle) {
        super(pMenu, pPlayerInventory, pTitle);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        // Get the position where the GUI is to be drawn
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // Render the background texture
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        // Render progress bar if crafting
        if (menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 89, y + 17, 176, 14,  menu.getScaledProgress(), 17);
        }

        // Render fuel bar if the STONE_TO_BOOT_O_TRON is fueled
        if (menu.isFueled()) {
            guiGraphics.blit(TEXTURE, x + 94, y + 36, 176, 0, 14, 15);
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float delta) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        this.renderBackground(guiGraphics, mouseX, mouseY);
        super.render(guiGraphics, mouseX, mouseY, delta);
        this.renderTooltip(guiGraphics, mouseX, mouseY);
        if (this.isHovering(x + 89, y + 17, 14, 15, mouseX, mouseY)) {
            String key = "container.bfdimod.stone_to_boot_o_tron." + (this.menu.isFueled() ? "converting" : "not_converting");
            guiGraphics.renderTooltip(this.font, Component.translatable(key), mouseX, mouseY);
        }
    }

    protected void renderBackground(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        // Draw the background texture
        guiGraphics.blit(TEXTURE, x, y, 0, 0, imageWidth, imageHeight);

        // Check and render the crafting progress
        if (menu.isCrafting()) {
            guiGraphics.blit(TEXTURE, x + 89, y + 17, 176, 14,  menu.getScaledProgress(), 17);
        }

        // Check and render the STONE_TO_BOOT_O_TRON fuel status
        if (menu.isFueled()) {
            guiGraphics.blit(TEXTURE, x + 94, y + 36, 176, 0, 14, 15);
        }
    }
}
