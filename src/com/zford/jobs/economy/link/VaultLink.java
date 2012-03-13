/*
 * Jobs Plugin for Bukkit
 * Copyright (C) 2011  Zak Ford <zak.j.ford@gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package com.zford.jobs.economy.link;

import org.bukkit.plugin.RegisteredServiceProvider;

import net.milkbowl.vault.economy.Economy;

import com.zford.jobs.Jobs;


/**
 * Class that interfaces with Vault and does the payment
 * @author phrstbrn
 *
 */
public class VaultLink implements EconomyLink {
    
    private Jobs plugin;
    
    /**
     * Constructor for creating the link
     */
    public VaultLink(Jobs plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public void pay(String playername, double amount) {
        RegisteredServiceProvider<Economy> provider = plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (provider == null)
            return;
        Economy economy = provider.getProvider();
        economy.depositPlayer(playername, amount);
    }
}