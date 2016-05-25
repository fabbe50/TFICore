package com.thefifthidiot.tficore.core.registry;

import com.thefifthidiot.tficore.common.blocks.BlockBase;

public class SpecialDropRegistry {
	public static void registerSpecialDrops() {
		BlockBase.registerSpecialDrop(ItemRegistry.testItem, BlockRegistry.testBlock);
	}
}