package com.coffeespace.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Industry {
    // Advanced Technologies & Software
    AI("Advanced Technologies & Software", "AI"),
    AR_VR("Advanced Technologies & Software", "AR/VR"),
    CLOUD_INFRASTRUCTURE("Advanced Technologies & Software", "Cloud Infrastructure"),
    DATA_SERVICES("Advanced Technologies & Software", "Data Services"),
    DEEPTECH("Advanced Technologies & Software", "DeepTech"),
    DEVELOPER_TOOLS("Advanced Technologies & Software", "Developer Tools"),
    GENERATIVE_TECH_AI("Advanced Technologies & Software", "Generative Tech/AI"),
    HARDWARE("Advanced Technologies & Software", "Hardware"),
    IOT("Advanced Technologies & Software", "IoT"),
    ROBOTICS("Advanced Technologies & Software", "Robotics"),
    SAAS("Advanced Technologies & Software", "SaaS"),
    SECURITY("Advanced Technologies & Software", "Security"),
    SEMICONDUCTORS("Advanced Technologies & Software", "Semiconductors"),
    SMART_CITIES_URBANTECH("Advanced Technologies & Software", "Smart cities/UrbanTech"),
    WEB3_BLOCKCHAIN("Advanced Technologies & Software", "Web3/BlockChain"),

    // Business, Work & Digital Services
    ADVERTISING("Business, Work & Digital Services", "Advertising"),
    ANALYTICS("Business, Work & Digital Services", "Analytics"),
    ENTERPRISE("Business, Work & Digital Services", "Enterprise"),
    FINTECH("Business, Work & Digital Services", "FinTech"),
    FUTURE_OF_WORK("Business, Work & Digital Services", "Future of Work"),
    GIG_ECONOMY("Business, Work & Digital Services", "Gig Economy"),
    GOVTECH("Business, Work & Digital Services", "GovTech"),
    HRTECH("Business, Work & Digital Services", "Human Capital/HRTech"),
    INSURANCE("Business, Work & Digital Services", "Insurance"),
    LEGALTECH("Business, Work & Digital Services", "LegalTech"),
    MARKETINGTECH("Business, Work & Digital Services", "MarketingTech"),
    MARKETPLACES("Business, Work & Digital Services", "Marketplaces"),
    PAYMENTS("Business, Work & Digital Services", "Payments"),
    PRODUCTIVITY_TOOLS("Business, Work & Digital Services", "Productivity Tools"),
    SALES_CRM("Business, Work & Digital Services", "Sales & CRM"),
    SMB_SOFTWARE("Business, Work & Digital Services", "SMB Software"),

    // Industry, Science & Infrastructure
    AGTECH("Industry, Science & Infrastructure", "AgTech"),
    AUTOTECH("Industry, Science & Infrastructure", "AutoTech"),
    BIOTECH("Industry, Science & Infrastructure", "BioTech"),
    CLIMATETECH_CLEANTECH("Industry, Science & Infrastructure", "ClimateTech/CleanTech"),
    CONSTRUCTIONTECH("Industry, Science & Infrastructure", "ConstructionTech"),
    ENERGYTECH("Industry, Science & Infrastructure", "EnergyTech"),
    HEALTHCARE("Industry, Science & Infrastructure", "Healthcare"),
    LOGISTICS("Industry, Science & Infrastructure", "Logistics"),
    MANUFACTURING("Industry, Science & Infrastructure", "Manufacturing"),
    MATERIAL_SCIENCE("Industry, Science & Infrastructure", "Material Science"),
    MEDICAL_DEVICES("Industry, Science & Infrastructure", "Medical Devices"),
    PHARMACEUTICALS("Industry, Science & Infrastructure", "Pharmaceuticals"),
    PROPTECH("Industry, Science & Infrastructure", "Real Estate/PropTech"),
    SPACE("Industry, Science & Infrastructure", "Space"),
    SUPPLY_CHAIN_TECH("Industry, Science & Infrastructure", "Supply Chain Tech"),
    TRANSPORTATIONTECH("Industry, Science & Infrastructure", "TransportationTech"),

    // Consumer, Media & Lifestyle
    AUDIOTECH("Consumer, Media & Lifestyle", "AudioTech"),
    COSMETICS("Consumer, Media & Lifestyle", "Cosmetics"),
    CREATOR_ECONOMY("Consumer, Media & Lifestyle", "Creator/Passion Economy"),
    DTC("Consumer, Media & Lifestyle", "Direct-to-Consumer DTC"),
    ECOMMERCE("Consumer, Media & Lifestyle", "E-commerce"),
    EDUCATION("Consumer, Media & Lifestyle", "Education"),
    ENTERTAINMENT_SPORTS("Consumer, Media & Lifestyle", "Entertainment & Sports"),
    FASHION("Consumer, Media & Lifestyle", "Fashion"),
    FOOD_BEVERAGE("Consumer, Media & Lifestyle", "Food and Beverage"),
    GAMING("Consumer, Media & Lifestyle", "Gaming"),
    HOSPITALITY("Consumer, Media & Lifestyle", "Lodging/Hospitality"),
    MEDIA_CONTENT("Consumer, Media & Lifestyle", "Media/Content"),
    MENTAL_HEALTH("Consumer, Media & Lifestyle", "Mental Health"),
    MESSAGING("Consumer, Media & Lifestyle", "Messaging"),
    PARENTING("Consumer, Media & Lifestyle", "Parenting/Families"),
    RETAIL("Consumer, Media & Lifestyle", "Retail"),
    SOCIAL_IMPACT("Consumer, Media & Lifestyle", "Social Impact"),
    SOCIAL_NETWORKS("Consumer, Media & Lifestyle", "Social Networks"),
    TRAVEL("Consumer, Media & Lifestyle", "Travel"),
    WELLNESS_FITNESS("Consumer, Media & Lifestyle", "Wellness & Fitness");

    private final String group;
    private final String value;
}
