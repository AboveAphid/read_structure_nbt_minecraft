It's really hard to find references for reading NBT (for minecraft structures) isn't it?
So hopefully this helps with that.

# What does a compressed NBT file look like?
A compressed NBT file will look something like this:

```
‹      ÿí—ÁŽÓ0†'¶“Mº¬BÀ3,°\8sÙBBâ¹é´±šÄ‘íÒ…— gÛ&­Ikb‹6R3þ{b«€˜?@óû2ûF	ÄXajhž¢i!³¥žØ—	ÐZê]RûPµá·}Lx„	zêLàÁ†z0Ìƒ	0°ãFÖ'ðX·NŸžÀY2ÀP†y0cÞ‰‡wâáÝ­Óç8ûÞ§™xxwõôù¢¾¨‡/·NŸ/êìé3ÖóÔñ>ÄŒõ¼ë«o}ÀÑL âÁP†0îwÁâÁP†0ÄCÛÏCÌ˜â¡Çí±p€!õ`Ø3ZM
…‹‚k“ŠÊ â™ÁYªišY¯
–·7P“šÉUÕ°/–	&0ÉdYËÊÞ\–zUŠ
3Åçæƒ6RÙJXe9¯L¹
ü†…UuÑµ’3#dµÝÃˆ˜ÁóŽØÖ°Õ¦R.¡G ¹':è=ÑÁþ…ŽÍøËn<Ë…Æb;¬s,æ·Ù~wG£]Iºò4»2<®tï‰³??+ážìÂCWžtWîßà±eÎj^ 1Ø´]b­|V²FÕü‰Œñ¡!ønAö‰—/ö½)Q×vBÉ—i!ÐŸ{Óæ¾îÉÕµZe˜®¥œµÜÓŽë¼¸ÅsnƒÑT#ËÎ×Ö²"8ƒpÎ±u™ó!¶“q±ÈMÑœg¢Z Cû	¶ó=ÛÓµ‘c—G(Ý:ÀÆû¥P#ë¿¥Ã™ðIs`¤oS™e«ZØ‰˜Q+ÜÅßwñ€ÍÀÕ@Âåï	­¾5j³ãÞä¿sâ­ŸãÍyWS ñ«!³ÿ»©mÂ˜§Ãü;š¢pþ‘þ•¾=Ÿÿ„_ ‡û£…
```

Just a crap tone of nonsense. If this is what your file looks like make sure to set is_compressed to TRUE!

# What does a uncompressed/normal NBT file look like?
Well uncompressed NBT looks much nicer and kind of like JSON files. 
If you want to see this yourself you can also open the file in Intelliji and it should decompile it for you*, which is very handy!
> If it doesn't decompile for you make sure you have the Compression type set to "GZipped".

> *The file will still be compressed (if you open it in Notepad, etc) the IDE just shows you a new uncompressed version.

Anyways here's a snippet of what they look like uncompressed:
```
"": {
	size: [ 5, 6, 7, ]
	entities: []
	blocks: [
		{
			pos: [ 1, 0, 0, ]
			state: 0
		},
		{
			pos: [ 1, 0, 1, ]
			state: 0
		},
		{
			pos: [ 1, 0, 2, ]
			state: 0
		},
		{
			pos: [ 1, 0, 3, ]
			state: 0
		},
    ...
  ],
  palette: [
		{
			Name: "minecraft:cobblestone"
		},
		{
			Properties: {
				axis: y
			}
			Name: "minecraft:oak_log"
		},
		{
			Name: "minecraft:oak_planks"
		},
		{
			Name: "minecraft:crafting_table"
		},
		{
			Name: "minecraft:stone"
		},
		{
			Name: "minecraft:air"
		},
		{
			Properties: {
				east: "false"
				waterlogged: "false"
				south: "true"
				north: "true"
				west: "true"
			}
			Name: "minecraft:spruce_fence"
		},
		{
			Properties: {
				hinge: left
				half: lower
				powered: "false"
				facing: south
				open: "true"
			}
			Name: "minecraft:oak_door"
		},
		{
			Properties: {
				east: "false"
				waterlogged: "false"
				south: "true"
				north: "true"
				west: "false"
			}
			Name: "minecraft:glass_pane"
		},
    ...
  ],
  DataVersion: 3839
```
